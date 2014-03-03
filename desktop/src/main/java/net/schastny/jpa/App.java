package net.schastny.jpa;

import java.util.List;

import net.schastny.jpa.dao.CategoryDAO;
import net.schastny.jpa.dao.PersonDAO;
import net.schastny.jpa.dao.ProjectDAO;
import net.schastny.jpa.domain.Category;
import net.schastny.jpa.domain.Person;
import net.schastny.jpa.domain.Project;

public class App {

    private CategoryDAO categoryDAO = new CategoryDAO();
    private PersonDAO     personDAO     = new PersonDAO();
    private ProjectDAO     projectDAO     = new ProjectDAO();
    
    private String formatString = "%1$-3s %2$-30s %3$s \n";

    public static void main(String[] args) {
        App app = new App();
        app.printCategoryInfo();
        app.printPersonInfo();
        app.printProjectInfo();
    }
    
    public void printCategoryInfo() {
         List<Category> catList = categoryDAO.findAll();
         System.out.printf(formatString, "Id", "Cat Name", "Projects");
         for (Category category : catList) {
             List<Project> categoryProjects = category.getProjects();
             String categoryProjectsString = " ";
             for (Project project : categoryProjects) {
                 categoryProjectsString += project.getName() + ". ";
             }
             
             System.out.printf(formatString, category.getId(), category.getName(), category.getProjects().size() + categoryProjectsString);
         }
         System.out.print("\n\n\n");
    }
    
    public void printPersonInfo() {
        List<Person> personList = personDAO.findAll();
         System.out.printf(formatString, "Id", "Person", "Projects");
         for (Person person : personList) {
             List<Project> personProjects = person.getProjects();
             String personProjectsString = " ";
             for (Project project : personProjects) {
                 personProjectsString += project.getName() + ". ";
             }
             
             System.out.printf(formatString, person.getId(), person.getName(), person.getProjects().size() + personProjectsString);
         }
         System.out.print("\n\n\n");
    }
    
    public void printProjectInfo() {
        List<Project> projectList = projectDAO.findAll();
         System.out.printf(formatString, "Id", "Project Name", "Persons");
         for (Project project : projectList) {
             List<Person> projectPersons = project.getPersons();
             String projectPersonsString = " ";
             for (Person person : projectPersons) {
                 projectPersonsString += person.getName() + ". ";
             }
             
             System.out.printf(formatString, project.getId(), project.getName(), project.getPersons().size() + projectPersonsString);
         }
         System.out.print("\n\n\n");
    }
}
