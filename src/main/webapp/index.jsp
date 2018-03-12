<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="ajax方式">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        function add() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                contentType: 'application/json',  
                url: "http://localhost:8080/webServiceTest/webservice/myservice/addUser/" ,//url
                data: '{"id":"2","name":"li"}',
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                }
            });
        }
        function deletee() {
            $.ajax({
            //几个参数需要注意一下
                type: "DELETE",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                contentType: 'application/json',  
                url: "http://localhost:8080/webServiceTest/webservice/myservice/delUser/1",//url
                data: '',
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                }
            });
        }
        function update() {
            $.ajax({
            //几个参数需要注意一下
                type: "PUT",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                contentType: 'application/json',  
                url: "http://localhost:8080/webServiceTest/webservice/myservice/updateUser/" ,//url
                data: '{"id":"1","name":"li"}',
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                }
            });
        }
        function select() {
            $.ajax({
            //几个参数需要注意一下
                type: "GET",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                //contentType: 'application/json',  
                url: "http://localhost:8080/webServiceTest/webservice/getUserById/1" ,//url
                data: '',
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                }
            });
        }
		 function get() {
            $.ajax({
            //几个参数需要注意一下
                type: "GET",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "http://localhost:8080/webServiceTest/webservice/myservice" ,//url
                data: '',
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                }
            });
        }
    </script>
</head>
<body>
<div id="form-div">
    <input type="button" value="添加" onclick="add()">
    <input type="button" value="删除" onclick="deletee()">
    <input type="button" value="修改" onclick="update()">
    <input type="button" value="查看" onclick="get()">
</div>
</body>

</html>