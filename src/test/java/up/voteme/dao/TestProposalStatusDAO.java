package up.voteme.dao;

import up.voteme.domain.ProposalStatus;

public class TestProposalStatusDAO {

	private ProposalStatus proposalStatus = new ProposalStatus();
	
	
/**	Example
 * 
	private UserJob userJob = new UserJob();

	@BeforeClass
	public static void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");
	}

	@Before
	public void init() {
		Profile profile = new Profile();
		userJob.setProfile(profile);
		userJob.setFirstname("Oleg");
		userJob.setLastname("Lastname");
		userJob.setPostalcode("10318");
		userJob.setStreet("Street");
		userJob.setCity("Berlin");
		userJob.setEmail("E-Mail");
		userJob.setIsActive(true);
		userJob.setPassword("pass");
	}

	@Test
	public void saveAndLoadUserJobTest() {

		userJob.save();

		UserJob loadedUserJob = userJob.load("E-Mail", "pass");

		Assert.assertEquals(loadedUserJob.getFirstname(), "Oleg");
		Assert.assertTrue(loadedUserJob.getId() > 0);
	}

	@Test
	public void updateUserJobTest() {

		userJob.setFirstname("OlegUpd");
		userJob.setLastname("LastnameUpd");
		userJob.setPostalcode("10318Upd");
		userJob.setStreet("StreetUpd");
		userJob.setCity("BerlinUpd");
		userJob.setEmail("E-MailUpd");
		userJob.setIsActive(false);
		userJob.setPassword("passUpd");

		userJob.update();

		UserJob loadedUserJob = userJob.load("E-MailUpd", "passUpd");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ loadedUserJob.toString());
		Assert.assertEquals(loadedUserJob.getFirstname(), "OlegUpd");
		Assert.assertEquals(loadedUserJob.getLastname(), "LastnameUpd");
		Assert.assertEquals(loadedUserJob.getPostalcode(), "10318Upd");
		Assert.assertEquals(loadedUserJob.getStreet(), "StreetUpd");
		Assert.assertEquals(loadedUserJob.getCity(), "BerlinUpd");
		Assert.assertEquals(loadedUserJob.getEmail(), "E-MailUpd");
		Assert.assertEquals(loadedUserJob.getIsActive(), false);
		Assert.assertEquals(loadedUserJob.getPassword(), "passUpd");

		Assert.assertTrue(loadedUserJob.getId() > 0);
	}	
**/
	
	
}
