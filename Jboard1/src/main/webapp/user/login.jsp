<%@page import="kr.co.jboard.vo.UserVO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 서버 부분
	request.setCharacterEncoding("UTF-8");
	String success = request.getParameter("success"); // Parameter -> 전송데이터
	
	// 현재 사용자 로그인 여부 확인
	UserVO sessUser = (UserVO) session.getAttribute("sessUser");
	
	if(sessUser != null){
		response.sendRedirect("/Jboard1/list.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="/Jboard1/css/style.css">
    <!-- 클라이언트 부분 --> 
    <script>
    	const success = <%= success %>;
    	
    	if(success == 100){
    		// 로그인 실패
    		alert('로그인에 실패했습니다. 다시 확인하시기 바랍니다.');
    	}else if(success == 101){
    		// 로그인 없이 글 목록 요청
    		alert('페이지에 접속할 수 없습니다. 로그인을 하셔야합니다.');
    	}
    
    </script>
</head>
<body>
    <div id="container">
        <header>
            <h3>Board System v1.0</h3>
        </header>
        <main>
            <section class="login">
                <form action="/Jboard1/user/loginProc.jsp" method="post">
                    <table border="0">
                        <tr>
                            <td><img src="/Jboard1/images/login_ico_id.png" alt="아이디"></td>
                            <td><input type="text" name="uid" placeholder="아이디 입력"></td>
                        </tr>
                        <tr>
                            <td><img src="/Jboard1/images/login_ico_pw.png" alt="비밀번호"></td>
                            <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인" class="btnLogin">
                </form>
                <div>
                    <h3>회원 로그인 안내</h3>
                    <p>
                        아직 회원이 아니시면 회원으로 가입하세요.
                    </p>
                    <a href="/Jboard1/user/terms.jsp">회원가입</a>
                </div>
            </section>
        </main>
        <footer>
            <p>ⓒcopyright 고성우.com</p>
        </footer>
    </div>
</body>
</html>