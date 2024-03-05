package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex04Lunch
 */
@WebServlet("/Ex04Lunch")
public class Ex04Lunch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");

		// 한식 리스트
		String[] kList = { "풍남옥", "그냥집밥", "해뜨는집", "좋은국밥", "신신식당", "설농탕" };
		// 중식리스트
		String[] cList = { "1515", "황금성", "말리화", "열도지" };
		// 일식리스트
		String[] jList = { "쿠로시로", "마시타라멘", "바른초밥", "공초밥", "카레카레" };

		// lunch 로 선택한 거에 따라서 해당 음식에 메뉴를 랜덤으로 하나 추천해주세요
		// 예 ) 중식선택 -> cList 중 랜덤으로 하나 추출해서 보여준다
		Random ran = new Random();
		PrintWriter out = response.getWriter();
		String lunch = request.getParameter("lunch");
		
		out.print("<html>");
		out.print("<body align = 'center'>");
		out.print("<h1>");
		out.print("오늘 추천 메뉴는 ");
		if (lunch.equals("한식")) {
			int kIndex = ran.nextInt(kList.length);
			String kFood = kList[kIndex];
			out.print(kFood);
		} else if (lunch.equals("중식")) {
			int cIndex = ran.nextInt(cList.length);
			String cFood = cList[cIndex];
			out.print(cFood);
		} else if (lunch.equals("일식")) {
			int jIndex = ran.nextInt(jList.length);
			String jFood = jList[jIndex];
			out.print(jFood);
		}
		out.print(" 입니다");
		out.print("</h1>");
		out.print("</body>");
		out.print("</html>");
		
		/*선생님 코드
		 * 
		 * String menu = null;
		 * if (lunch.equals("한식")){
		 * 		menu = kList[ran.nextInt(kList.length)];
		 * }
		 * if else(){
		 * }....
		 * out.print(menu)
		 * 
		 * */

	}

}
