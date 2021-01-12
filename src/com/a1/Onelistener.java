package com.a1;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Onelistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Map map=new HashMap();
            for(int i=0;i<20;i++){
                Connection conn=JDBC.getConnection();
                System.out.println(conn+"来了");
                map.put(conn,true);
            }
            ServletContext application=sce.getServletContext();
            application.setAttribute("key",map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application=sce.getServletContext();
        Map map=(Map)application.getAttribute("key");
        Iterator iterator=map.keySet().iterator();
        while (iterator.hasNext()){
            Connection connection= (Connection) iterator.next();
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(connection+"走了");
            }
        }
        application.removeAttribute("key");
    }
}
