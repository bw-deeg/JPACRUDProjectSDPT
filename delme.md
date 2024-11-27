### Create a Spring Boot Project for your MVC controller, DAO, and DAO implementation.

1. Copy the base package name from your entity class (the package name up to but not including `.entities`)
1. Create a new _Spring Starter Project_.
1. Paste the base package name into the _Package_ field.
1. Give the project an appropriate name (this project name will appear in the URL once you deploy the project.)
1. Set the _Type_ to **Gradle - Groovy** 
1. Set the _Java Version_ to **21**.
1. Set the _Packaging_ to **War**.
1. Add the _Spring Web_, _Spring Data JPA_, and _MySQL Driver_ dependencies.

1. Add JSP dependencies to the `dependencies` block in the Boot project's `build.gradle`:

   ```groovy
      implementation group: 'jakarta.servlet.jsp.jstl', name: 'jakarta.servlet.jsp.jstl-api', version: '3.0.0'
      implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.0'
      compileOnly group: 'jakarta.servlet', name: 'jakarta.servlet-api', version: '6.0.0'
      implementation 'org.apache.tomcat.embed:tomcat-embed-jasper' 
      implementation 'org.glassfish.expressly:expressly:6.0.0-M1'
   ```

   Add above `repositories`:

   ```groovy
   eclipse.wtp.facet {
      facet name: 'jst.web', version: '6.0'
   }
   ```

1. Connect the projects using your Boot project's `settings.gradle` and `build.gradle`.

1. Do a Gradle refresh.

1. Update the Boot project's `application.properties` using the one from the _BootMVCVideoStore_ application.

   * Choose an unused port number.
   * Change the schema name in the datasource URL, the username, and the password to match your MySQL schema model.

1. Under `src/main` create `webapp/WEB-INF/` for your JSPs.
   *  Static content (HTML, CSS, image files) will go in `src/main/webapp/`.

1. Create packages for your controller and DAO, and get a basic controller route and JSP view working.

### Next Steps

1. Finish designing your database schema. This will be a single-table application.  After completing the column definitions of your entity table, add data for them in the _Inserts_ tab and forward engineer.

1. Update your Java entity class adding fields for your new columns.  Don't forget getters/setters and a toString, and update the JUnit test appropriately.

1. With your DB and entity complete you can focus on implementing CRUD using MVC.

1. As you work, commit and push frequently.

<hr>

[Prev](README.md) | [Up](README.md)
