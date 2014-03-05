package up.modell;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.expressions.ExpressionBuilder;

import up.voteme.domain.Category;
import up.voteme.domain.Document;
import junit.framework.TestCase;

public class SimpleJunitTestClass extends TestCase {

	private EntityManagerFactory entityManagerFactory;
	
	@Override
	protected void setUp() throws Exception {
		// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
		// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate" );
	}

	@Override
	protected void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	public void testBasicUsage() {
				System.out.println("run as Junit test - testBasicUsage() started...");
			
				// create a couple of categories...
				EntityManager entityManager = entityManagerFactory.createEntityManager();
/*				entityManager.getTransaction().begin();
				entityManager.persist( new Category( "Transport") );
				entityManager.persist( new Category( "Zdravoohranenie") );
				entityManager.persist( new Category( "Health Care") );
				entityManager.persist( new Category( "Emergency forces") );
				entityManager.getTransaction().commit();
				entityManager.close();
*/
				// now lets pull categories from the database and list them
				entityManager = entityManagerFactory.createEntityManager();
			//	entityManager.getTransaction().begin();
		
				List<Category> result =  entityManager.createQuery( "SELECT c FROM Category c" ).getResultList();
		        for ( Category categ : result ) {
					System.out.println( categ );
				}
 /*	
				System.out.println( entityManager );
				List<Documentd> result =  entityManager.createQuery( "SELECT d FROM Documentd d" ).getResultList();
		        for ( Documentd doc : result ) {
					System.out.println( doc );
				}
*/		        
		        
		 //       entityManager.getTransaction().commit();
		        entityManager.close();
	}

}
