
public class IntSymb extends Symb
{
	private int value;
	
	IntSymb(String name, int value)
	{
		this(name);
		
		this.value = value;
	}
	
	IntSymb(String n)
	{
		super(n);
	}

	@Override
	public String name()
	{
		return "(" + super.name() + ":" + value + ")";
	}
	
	@Override
	public String toString()
	{
		return name();
	}
}
