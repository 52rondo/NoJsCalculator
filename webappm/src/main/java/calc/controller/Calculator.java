package calc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Calculator")
public class Calculator extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sess =  req.getSession();
		//make sure not null, then cast as string 
		String numTotal="";
		if(sess.getAttribute("numTotal") != null) {
			numTotal = (String) sess.getAttribute("numTotal"); 
		}
		
		String num = req.getParameter("digit");
		if (num != null) {
			if(num.equals("=")) {
				//turn calculation string into char arraylist to calculate
				//traverse thru each char, if operator, 
				ArrayList<Integer> calcArr = new ArrayList<Integer>();
				String currentNum = "";
				
				for(int i = 0; i < numTotal.length(); i++) {
					//if current char is number
					if(47 < numTotal.charAt(i) && numTotal.charAt(i) < 58) {
						if(i == 0 ) {
							currentNum = currentNum.concat(String.valueOf(numTotal.charAt(i)) );
						}else if(47 < numTotal.charAt(i - 1) && numTotal.charAt(i - 1) < 58) {
							currentNum = currentNum.concat(String.valueOf(numTotal.charAt(i)) );
						}//current num is pushed into stack, currentNum empty
						else if(currentNum.equals("")){
							currentNum = String.valueOf(numTotal.charAt(i));
						}else {
							System.out.println("smth wrong");
						}
					}//if current char is operator, flush currentNum into stack
					//change operators into negative integers and add to stack
					else {
						calcArr.add(Integer.parseInt(currentNum));
						currentNum = "";
						switch (numTotal.charAt(i)) {
						case 43:
							calcArr.add(-1);
							break;
						case 45:
							calcArr.add(-2);
							break;
						case 42:
							calcArr.add(-7);
							break;
						case 47:
							calcArr.add(-8);
							break;
						default:
							break;
						}
//						calcArr.add( String.valueOf(numTotal.charAt(i)) ); 
					}
					
					//if last char, flush cuurentNum
					if(i == (numTotal.length() - 1)) {
						calcArr.add( Integer.parseInt(currentNum) ); 
						currentNum = "";
					}
					
				}
				System.out.println("calcArr: " + calcArr);
				numTotal = "";
				sess.setAttribute("numTotal", "");
				
				// =======Calculation Start ===========
//				Iterator it = calcArr.iterator();
//				while(it.hasNext()) {
////					System.out.print(it.next() + "");
//				}
//				int t = calcArr.size();
//				for(int i = 0; i < t; i ++) {
////					System.out.println( calcArr.remove(0));
//				}
				
				ArrayList<Integer> calcStack = new ArrayList<Integer>();
				ArrayList<Integer> numStore = new ArrayList<Integer>();
				int currentOp = 0;
				for(int i = 0; i < calcArr.size(); i++) {
					//identify num or operator 
					//if operator (will be negative int)
					if(calcArr.get(i) < 0) {
						if(currentOp == 0) {
							currentOp = calcArr.get(i);
							calcStack.add(calcArr.get(i));
							System.out.println("add to calcStack: " + calcStack);
						}else {
							//already an operator before, if priority first>second pop out and calculate and push back
							//priority: 
							int sSize = calcStack.size();
							System.out.println("first op - second op: " + (currentOp - calcArr.get(i)) );
							if((currentOp - calcArr.get(i)) < 5) {
								System.out.println("first has higher priority");
//								get previous three in stack, throw in calculate, get sum
//								if calcStack still has more, get three more
								int index = calcStack.indexOf(currentOp);
								int sum = Operations.calculate(calcStack.remove(index - 1), calcStack.remove(index - 1), calcStack.remove (index - 1));
								calcStack.add(sum);
								System.out.println("sum is " + sum);
								while(calcStack.size()>=2) {
									sum = Operations.calculate(calcStack.remove(0), calcStack.remove(0), calcStack.remove(0) );
									System.out.println("operate----");
									calcStack.add(sum);
									System.out.println("sum is " + sum);
								}
								calcStack.add(calcArr.get(i) );
								System.out.println("calcStack is: " + calcStack);
							}else {
								calcStack.add(calcArr.get(i));
								System.out.println("add to stack: " + calcStack);
							}
							currentOp = calcArr.get(i);
							
						}
						
					}//if its number
					else {
						calcStack.add(calcArr.get(i));
						System.out.println("add to calcStack: " + calcStack);
					}
					
				}
//				calculate the rest of the nums still in stack
				if(!calcStack.isEmpty()) {
					int result = -100;
					if(calcStack.contains(-7) || calcStack.contains(-8)) {
						if(calcStack.contains(-1) || calcStack.contains(-2)) {
							int index;
							if(calcStack.contains(-7)) {
								index = calcStack.indexOf(-7);
							}else {
								index = calcStack.indexOf(-8);
							}
							int sum2 = Operations.calculate(calcStack.remove(index - 1), calcStack.remove(index - 1), calcStack.remove (index - 1));
							result = Operations.calculate(calcStack.remove(0), calcStack.remove(0), sum2);
						}else {
							result = Operations.calculate(calcStack.remove(0), calcStack.remove(0), calcStack.remove(0));							
						}
						
					}else {
						result = Operations.calculate(calcStack.remove(0), calcStack.remove(0), calcStack.remove(0));
					}
					calcStack.add(result);
				}
				if(!calcStack.isEmpty()) {
					int finalResult = calcStack.remove(0);
					System.out.println("final sum: " + finalResult);
					sess.setAttribute("result", finalResult);
				}
				
				
				
				//  ====== Calculation End ==========
				
				
			}else if(num.equals("+") || num.equals("-") || num.equals("*") || num.equals("/") ) {
				numTotal += num;
				sess.setAttribute("numTotal", numTotal);
				System.out.println(numTotal);
			
			}else if(num.equals("C")) {
				numTotal = "";
				sess.setAttribute("numTotal", numTotal);
				
			}else {
				numTotal += num;
				sess.setAttribute("numTotal", numTotal);
				System.out.println(numTotal);
			}
			
		
			
		}else {
			System.out.println("is null");
		}
		
		//add result into response
		
		
		String url = "/frontpage.jsp";
		javax.servlet.RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
