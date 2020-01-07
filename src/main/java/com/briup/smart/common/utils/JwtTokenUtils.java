package com.briup.smart.common.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

//import org.springframework.security.core.userdetails.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author HP
 *jwt工具类
 */
public class JwtTokenUtils {
	private static Logger log = LoggerFactory.getLogger(JwtTokenUtils.class);

    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    // jwt配置信息
    public static final String base64Secret ="MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    private static final String clientId = "098f6bcd4621d373cade4e832627b4f6";
    private static final String name = "restapiuser";
    private static final int expiresSecond = 172800000;
    /**
     * 解析jwt
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
    	Claims claims=null;
    	try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            
        } catch (ExpiredJwtException  eje) {
            log.error("===== Token过期 =====", eje);
            new Exception("token过期");
        } catch (Exception e){
            log.error("===== token解析异常 =====", e);
            new Exception("token解析异常");
        }
        return claims;
    }

    /**
     * 构建jwt
     * @param userId
     * @param username
     * @return
     */
    public static String createJWT(Long userId, String username) {
    	JwtBuilder builder =null;
        try {
            // 使用HS256加密算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);

            //生成签名密钥
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            //userId是重要信息，进行加密下
            String encryId = Base64Util.encode(userId.toString());

            //添加构成JWT的参数
            builder = Jwts.builder().setHeaderParam("typ", "JWT")
                    // 可以将基本不重要的对象信息放到claims
                    .claim("userId", encryId)
                    // 代表这个JWT的主体，即它的所有人
                    .setSubject(username)
                    // 代表这个JWT的签发主体；
                    .setIssuer(clientId)
                    // 是一个时间戳，代表这个JWT的签发时间；
                    .setIssuedAt(new Date())
                    // 代表这个JWT的接收对象；
                    .setAudience(name)
                    .signWith(signatureAlgorithm, signingKey);
            //添加Token过期时间
            int TTLMillis = expiresSecond;
            if (TTLMillis >= 0) {
                long expMillis = nowMillis + TTLMillis;
                Date exp = new Date(expMillis);
                builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
                        .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
            }

           
        } catch (Exception e) {
            log.error("签名失败", e);
            new Exception("签名失败");
        }
        //生成JWT
        return builder.compact();
    }

    /**
     * 从token中获取用户名
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUsername(String token, String base64Security){
        return parseJWT(token, base64Security).getSubject();
    }

    /**
     * 从token中获取用户ID
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserId(String token, String base64Security){
        String userId = parseJWT(token, base64Security).get("userId", String.class);
        return Base64Util.decode(userId);
    }

    /**
     * 是否已过期
     * @param token
     * @param base64Security
     * @return
     */
    public static boolean isExpiration(String token, String base64Security) {
        return parseJWT(token, base64Security).getExpiration().before(new Date());
    }
	
	
	
}
