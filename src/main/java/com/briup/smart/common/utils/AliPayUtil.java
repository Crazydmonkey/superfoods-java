package com.briup.smart.common.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AliPayUtil {
	/**
	 * 服务网关  沙箱环境都是这个
	 */
	public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";
	/**
	 * 应用id 后期可以替换成自己的id
	 */
	public static String appId = "2016101600702002";
	/**
	 * 用户私钥  后期替换成自己的私钥
	 */
	public static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEA"
			+ "AoIBAQCSaqdbqaVuRacuZkqz3jLbk/zN+aV4XFvMXDkbS2wevuctAfLja8CmN6V3Jdzy"
			+ "alJDuR7RfNC61sgkhH8iMmL3oLidL72uicc1DP8PqOGNhTs1JlQuT861r+kyF3MqJtx2"
			+ "g3/aqVstAYOplua3vw/b6SESYVQYPjfbO5QQYfeenG2maRgBpThjjEFkVX2jgz78h5yv"
			+ "I5WM3aC8xbiAKl0I57/04PQ5L04EjD8kGwU8BoqhgZ9wqRM3KSCIJoNYGUhY1aeQ+Dk4"
			+ "wSjBGlZ1UF073DISsUsQShfherN1HcwA97/BmQain0JSNqeo2TpojuTr2H/y6/kG5c4D"
			+ "IkAKsOE7AgMBAAECggEAIumRjHbQPpIXQiYcC/WgtOD9t/OeNCv5q6oV5989IbutjfrX"
			+ "+sh3wGqmZtm9bIRTp1hd89/KObL7OFHrqrDPDnLhcoGuvg6WVJ0LuKUxWzh4nLzN99kJ"
			+ "1iLi/RHAYT2w9gV3GCGn3vxsc6TK0OebFXnqa+KPVdSIJxt2u81QaR5RG9gKR6y6y3vT"
			+ "RjEucjzkP0xQKptCvXjpCD/ZbKwqVWLjd6FRVWlXoGS1kJZITk7FTQEONFurcxSicpSo"
			+ "JLMkSw0qjdtuQCKO4DDTjn49ggTHg9Qzey/6kKANdTwlYAGpTslDzOJdByi0U1Gsz/Qd"
			+ "pfxM+ewSus908QBSC5slYQKBgQDRop/gVYLnJ+Kfc+HQe1iWY0Esdtk4O1oHUAACF+oC"
			+ "oZxlazixSshhTKK+3zCItm4fuvSWOiOrBgC3MSTftGEax2g5l9SCO/HmbCwDrcDOOx3H"
			+ "npJwIWQ1JqpY+fhh4bRtxGXz9tYeYZTW4U7HAikzEpIFMbDOHm2mnqCiaztsSwKBgQCy"
			+ "zKRfXtPjsz2ISPB+/F9NVQCpBGsbNJbfX30QatBNAqxN3bMwU2sNY2Ryqti/HvpWsGLy"
			+ "jM6BlotItB6S/VtGvm/5qUtbc9wq+awYcDc+ZlLC+LACmpKjCxucTH85/VXgNZwBe+YS"
			+ "gEXjhRy4/xPoCdUE4iQ9GAoSUWaVti1o0QKBgFv+2dpArGl0f2cqG3a6Km4UsI0quriK"
			+ "kz+SQ+6nP/JXqaJ4IzDqeHT6hJDusQXNyRXznVIvwWdUAwxhbKUfK13tFDfyATgFxmow"
			+ "HkCfB3V5S+BGHk1G2grZJPhW+kE6I0voXDVrpRtAB2klBsUelaXsCFhvLf/GKqhsBGJC"
			+ "XJlxAoGBAJeDADrs0WMfbSICpQEGfP+76y5OVzCblMm+Ue1Khi7r9/SXzJND7PBQbDsa"
			+ "+UajSoGRQJfGp+t6FZdLQqlOVj2RfLO0OO5LNKOaJLIkzTtsW+9p60SZlW7iJ8h/rkQG"
			+ "n/G5m/RJ+IFu/0o4b0l4pXa4djGILCs1Jru1DNgKo1oxAoGAFrMVe8N79qI4kQh0jZ9j"
			+ "HyyyzXITS1lqD3laA/sxN7NPVaxX6ZgUC/C9ZwU49BpM/xrWOAznocO3A5ERAQQfb/Wu"
			+ "YBY37jngzFo/3vp6uwLuSnPkB5iBrG5KYUs4ehsHtWtdPI9GCe2JcNwBChGbwgsfh1Py"
			+ "sA6EMNfz60AwZnA=";
	/**
	 * 发送数据的格式 目前只能为json
	 */
	public static String format = "json";
	/**
	 * 设置字符集编码 目前只能为utf-8
	 */
	public static String charset = "utf-8";
	/**
	 * 支付宝公钥 后期替换成自己的支付宝公钥
	 */
	public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx"
			+ "AOoKMiNZsclM/5Z5y4sSjDIwWcWnVHzOWqaSaanjweSuNycjdlU9YXohZdV+lRKzIFK8"
			+ "emckV/31v/E0bfUTkwWayQVJbSF1f8ZFtxOHJMP8N1VD9H5ChfHxVv3PBMPUJZDIoyWc"
			+ "eQ1oTneui4j9CCrb7/GdoTNgyadR/dIcRyecvxE8FTy1pjE20G/pxn4UhQMLoY4FvM5W"
			+ "3AxPVw/ZtsJDBtiXiwdDcwXEFiYSgoCToCaUQd5p3qYKClCGwOJeOC2DbTRgAy0fSCem"
			+ "BG/KkTdavhsE9MLuRbazZGKNFUMVaMCtT0EWtW9A+euTsJAIIg3w+DPKaQaRyye8/xcR"
			+ "wIDAQAB";
	/**
	 * 支付宝签名 目前是 RSA2
	 */
	public static String signType = "RSA2";
	/**
	 * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数， 必须外网可以正常访问
	 */
	public static String return_url = "http://localhost:8080/buycar";
	/**
	 * 异步通知路径 
	 */
	//public static String notify_url = "http://xm123.free.idcfengye.com/receiveAsynchronizedNotify";

	
	public static String sellerId = "2088102179873693";
	
	public static AlipayClient getAlipayClient() {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayUtil.serverUrl, AliPayUtil.appId,
				AliPayUtil.privateKey, AliPayUtil.format, AliPayUtil.charset, AliPayUtil.publicKey,
				AliPayUtil.signType);
		return alipayClient;
	}
}

