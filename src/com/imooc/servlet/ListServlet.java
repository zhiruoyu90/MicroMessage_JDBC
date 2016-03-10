package com.imooc.servlet;

import com.imooc.bean.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-03-08.
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        List<Message> messageList = null;

        String qCommand = req.getParameter("q_command");
        String qDescription = req.getParameter("q_description");
        req.setAttribute("q_command", qCommand);
        req.setAttribute("q_description", qDescription);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_message?useUnicode=true&amp;characterEncoding=UTF-8", "root", "wang110");
//            缓存前端参数
            StringBuilder sqlBuiler = new StringBuilder("select id, command, description, content from message where 1 = 1 ");
            List<String> paramList = new ArrayList<String>();
            if(null != qCommand && !("").equals(qCommand)) {
                sqlBuiler.append(" and command = ?");
                paramList.add(qCommand);
            }
            if(null != qDescription && !("").equals(qDescription)) {
                sqlBuiler.append(" and description like '%' ? '%'");
                paramList.add(qDescription);
            }
            PreparedStatement preStmt = conn.prepareStatement(sqlBuiler.toString());
            for(int i =0; i < paramList.size(); i++) {
                preStmt.setString(i+1,paramList.get(i));
            }

            ResultSet rs = preStmt.executeQuery();
            Message message = null;
            messageList = new ArrayList<Message>();
            while (rs.next()) {
                message = new Message();
                message.setId(rs.getInt("ID"));
                message.setCommand(rs.getString("COMMAND"));
                message.setDescription(rs.getString("DESCRIPTION"));
                message.setContent(rs.getString("CONTENT"));
                messageList.add(message);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("messageList", messageList);
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
