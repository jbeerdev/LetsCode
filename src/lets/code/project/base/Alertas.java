package lets.code.project.base;

public class Alertas {

	public int alertid;
	public String alerttext;
	public String alertdate;

	@Override
	public String toString()
	{
		return "Alert ID: "+alertid+ " Alert Text: "+alerttext+ " Alert Date: "+alertdate;

	}
}
