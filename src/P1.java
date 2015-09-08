import java.io.*;
import java.util.List;

class P1
{
	public static void main(String args[])
	{
		System.out.println(
			"Project 1 test driver. Enter any of the following commands:\n"
			+ "  (Command prefixes are allowed)\n"
			+ "\tOpen (a new scope)\n"
			+ "\tClose (innermost current scope)\n"
			+ "\tQuit (test driver)\n"
			+ "\tDump (contents of symbol table)\n"
			+ "\tInsert (symbol,integer pair into symbol table)\n"
			+ "\tLookup (lookup symbol in top scope)\n"
			+ "\tGlobal (global lookup of symbol in symbol table)\n"
			+ "");

		try
		{
			SymbolTable table = new SymbolTable();
			
			boolean acceptInput = true;
			while (acceptInput)
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						System.in));
	
					String input = reader.readLine().toUpperCase();
	
					switch(input)
					{
						case "OPEN":
							
							table.openScope();
							System.out.println("New cope opened.");
							break;
							
						case "CLOSE":
							
							table.closeScope();
							System.out.println("Top scope closed.");
							break;
							
						case "DUMP":

							System.out.println("Contents of symbol table:");
							
							ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
							PrintStream printStream = new PrintStream(outputStream);
							table.dump(printStream);
							
							printStream.flush();
							printStream.close();
							
							System.out.println(outputStream.toString());
							break;
							
						case "INSERT":
						{
							System.out.println("Enter symbol:");
							String symbolName = reader.readLine();
							
							System.out.println("Enter associated integer:");
							String symbolValue = reader.readLine();
							
							Symb symbol = new IntSymb(symbolName, Integer.parseInt(symbolValue));
							table.insert(symbol);

							System.out.println(symbol.name() + " entered into symbole table.");
							break;
						}
						case "LOOKUP":
						{
							System.out.println("Enter symbol:");
							String symbolName = reader.readLine();
							
							Symb symbol = table.localLookup(symbolName);

							if(symbol != null)
							{
								System.out.println(symbol.name() + " found in top of scope");
							}
							else
							{
								System.out.println(symbolName + " not found in top of scope");
							}
							break;
						}
						case "GLOBAL":
						{
							System.out.println("Enter symbol:");
							String symbolName = reader.readLine();
							
							Symb symbol = table.globalLookup(symbolName);

							if(symbol != null)
							{
								System.out.println(symbol.name() + " found in symbol table");
							}
							else
							{
								System.out.println(symbolName + " not found in symbol table");
							}
							break;
							
						}
						case "QUIT":

							System.out.println("Testing done");
							acceptInput = false;
							break;
							
						default:
							
							System.out.println("Command not accepted, try again:");
							break;
					}
			}
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (EmptySTException e)
		{
			e.printStackTrace();
		}
	} // main
} // class P1
