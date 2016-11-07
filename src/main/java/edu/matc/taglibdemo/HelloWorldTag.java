package edu.matc.taglibdemo;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by bvue0 on 11/6/2016.
 */
public class HelloWorldTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("Hello Enterprise Java!");

        try{
        Date date1 = new Date();
        SimpleDateFormat dateFormat =
                new SimpleDateFormat ("E MM/dd/yyyy 'at' hh:mm:ss a zzz");
        out.println( "<p>Current Date and Time: "
                    + dateFormat.format(date1)+"</p>");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = sdf.parse("10/31/2016");

        if(date1.compareTo(date2)==0){
            out.println("<p>Happy Halloween!</p>");
        }else{
            out.println("<p>It is not Halloween.</p>");
        }

        }catch(ParseException ex){
            ex.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            out.println("<p>Good Morning, Sunshine!</p>");
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            out.println("<p>Good Afternoon!</p>");
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            out.println("<p>Good Evening!</p>");
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            out.println("<p>Good Night!</p>");
        }





    }




}
