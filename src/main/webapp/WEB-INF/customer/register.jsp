<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
    </style>
</head>
<body>
        <form method="post" name="reg" action="register.action">
                <table cellpadding="3" cellspacing="1" align="center" class="" id="">
                    <tr>
                        <td width="40%" class=""><b>用户名</b>：<br>
                        注册用户名长度限制为0－16字节</td>
                        <td width="60%" class="">
                        <input maxLength="8" size="32" name="userid" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        <font color="#FF0000">*</font></td>
                    </tr>
                    <tr>
                        <td width="40%" class=""><b>密码(至少6位，至多8位)</b>：<br>
                        请输入密码，区分大小写。<br>
                        请不要使用任何类似 \'*\'、\' \' 或 HTML 字符'
                        </td>
                        <td width="60%" class="">
                        <input type="password" maxLength="8" size="32" name="password" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        <font color="#FF0000">*</font></td>
                    </tr>
                    <tr>
                        <td width="40%" class=""><b>密码(至少6位，至多8位)</b>：<br>
                        请再输一遍确认</td>
                        <td class="">
                        <input type="password" maxLength="8" size="32" name="password2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        <font color="#FF0000">*</font></td>
                    </tr>
                    <tr>
                        <td class=""><b>昵称</b></td>
                    </tr>
                    <tr>
                        <td class=""><b>地址1</b>：</td>
                        <td class="">
                        <input type="text" size="64" maxlength="32" name="address1" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        </td>
                    </tr>
                    <tr>
                        <td class=""><b>地址2</b>：</td>
                        <td class="">
                        <input type="text" size="64" maxlength="32" name="address2" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        </td>
                    </tr>
                    <tr>
                        <td class=""><b>真实姓名</b>：</td>
                        <td class="">
                        <input type="text" size="32" maxlength="8" name="zip" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        </td>
                    </tr>
                    <tr>
                        <td class=""><b>性别</b>：</td>
                        <td class="">
                        <input type="text" size="32" maxlength="8" name="zip" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        </td>
                        </tr>
                    <tr>
                        <td class=""><b>电话</b>：</td>
                        <td class="">
                        <input type="text" size="32" maxlength="16" name="homephone" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                        </td>
                    </tr>
                    <tr>
                        <td class="" valign="middle" colspan="2" align="center">
                        <input type="button" value="注 册" onclick="javascript:checkReg()">&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="清 除"></td>
                    </tr>
                </table>
            </form>
</body>
</html>