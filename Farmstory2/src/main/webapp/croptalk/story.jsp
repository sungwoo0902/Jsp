<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 개발/배포에서 ContextPath 포함 여부에 따른 동적처리 -->
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리::농작물이야기</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
    <div id="container">
        <header>
            <a href="../index.jsp" class="logo"><img src="../images/logo.png" alt="로고"/></a>
            <p>
                <a href="#">HOME |</a>
                <a href="#">로그인 |</a>
                <a href="#">회원가입 |</a>
                <a href="#">고객센터</a>
            </p>
            <img src="../images/head_txt_img.png" alt="3만원 이상 무료배송"/>
            
            <ul class="gnb">
                <li><a href="#">팜스토리소개</a></li>
                <li><a href="#"><img src="../images/head_menu_badge.png" alt="30%"/>장바구니</a></li>
                <li><a href="#">농작물이야기</a></li>
                <li><a href="#">이벤트</a></li>
                <li><a href="#">커뮤니티</a></li>
            </ul>
        </header>

        <div id="sub">
            <div><img src="${ctxPath}/images/sub_top_tit3.png" alt="CROP TALK"></div>
            <section class="croptalk">
                <aside>
                    <img src="${ctxPath}/images/sub_aside_cate3_tit.png" alt="농작물이야기"/>

                    <ul class="lnb">
                        <li class="on"><a href="${ctxPath}/croptalk/story.jsp">농작물이야기</a></li>
                        <li><a href="${ctxPath}/croptalk/grow.jsp">텃밭가꾸기</a></li>
                        <li><a href="${ctxPath}/croptalk/school.jsp">귀농학교</a></li>
                    </ul>

                </aside>
                <article>
                    <nav>
                        <img src="../images/sub_nav_tit_cate3_tit1.png" alt="농작물이야기"/>
                        <p>
                            HOME > 농작물이야기 > <em>농작물이야기</em>
                        </p>
                    </nav>

                    <!-- 내용 시작 -->
                    <img src="../images/board_list.png" alt="">

                    <!-- 내용 끝 -->

                </article>
            </section>

        </div>
        
        
        <footer>
            <img src="../images/footer_logo.png" alt="로고"/>
            <p>
                (주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호<br />
                등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동<br />
                대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01) 234-5678 / 경기도 성남시 잘한다구 신난다동 345<br />
                <em>Copyright(C)홍길동 All rights reserved.</em>
            </p>
        </footer>
    </div>    
</body>
</html>