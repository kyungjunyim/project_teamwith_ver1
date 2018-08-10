package com.teamwith.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.teamwith.dao.TeamWithServiceDao;
import com.teamwith.vo.LayoutVO;
import com.teamwith.vo.SkillRoleVO;

/**
 * Application Lifecycle Listener implementation class LoadData
 *
 */
@WebListener
public class LoadData implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoadData() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = arg0.getServletContext();
    	TeamWithServiceDao ts = TeamWithServiceDao.getInstance();
    	Map<String,String> loadedRegion;
    	Map<String,String> loadedCategories;
    	List<SkillRoleVO> loadedSkills;
    	Map<String,String> loadedRoles;
    	Map<String,String> loadedPraises;
    	Map<String,String> loadedTendencies;
    	List<LayoutVO> loadedLayouts;
    	
    	loadedRegion = ts.getRegion();
    	loadedCategories = ts.getCategory();
    	loadedSkills= ts.getSkillRole();
    	loadedRoles = ts.getRole();
    	loadedPraises = ts.getPraise();
    	loadedTendencies = ts.getTendency();
    	loadedLayouts = ts.getLayout();
    	
    	sc.setAttribute("regions", loadedRegion);
    	sc.setAttribute("categories", loadedCategories);
    	sc.setAttribute("skills", loadedSkills);
    	sc.setAttribute("roles", loadedRoles);
    	sc.setAttribute("praises", loadedPraises);
    	sc.setAttribute("tendencies", loadedTendencies);
    	sc.setAttribute("layouts", loadedLayouts);
    	
    }
	
}
