/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbgr;

import entity.Gruppyi;
import entity.Studentyi;
import hiber.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

/**
 *
 * @author 18749
 */   


public class DBGr {

    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        // String hql = "FROM Gruppyi WHERE nazvanie like 'A-%' ";
        Query query = s.createQuery("From Studentyi");
        Query query1 = s.createQuery("From Gruppyi");
        List <Studentyi> students = query.list();
        List <Gruppyi> grup = query1.list();
        /*for(Studentyi st: students){
        System.out.println(st.getFamiliya() +"\t " +st.getImya() 
                            +" " + st.getOtchestvo() +"\t " + st.getGruppyi().getNazvanie());
        }*/
             
        for(Gruppyi g: grup){
            System.out.println("Численность группы " + g.getNazvanie() + " составляет:  "+  g.getStudentyis().size() + " человек");
        } 
         
        String hql = "FROM Gruppyi WHERE nazvanie like 'A-%' ";
        Query query11 = s.createQuery(hql);
        List<Gruppyi> gr = query11.list();
        
        for(Gruppyi gru: gr){
            System.out.println("Группа " + gru.getNazvanie());
        }
        s.close();
        sf.close();
    }   
}
