package com.Sankar.passwordgenerator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
//TODO password algorithm, docs, tablet format
public class MainActivity extends Activity {

	private static final String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String specials = "~!@$%^&*-+()/\\|[]{}`?,.;:";

    private int backButtonCount = 0;
	private static boolean includeSpecial;
	private static boolean includeUppers;
	private static boolean includeNumber;
	private EditText generatedPassword;
	private EditText askLength;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		askLength = (EditText) findViewById(R.id.editText1);
		generatedPassword = (EditText) findViewById(R.id.editText);

	}


	public void onCheckboxClicked(View view){
		boolean checked = ((CheckBox) view).isChecked();
		switch(view.getId()) {
			case R.id.allowNums:
				includeNumber = checked;
				break;
			case R.id.allowSpecs:
				includeSpecial = checked;
			case R.id.allowUps:
				includeUppers = checked;
		}//end switch

		//hide the keyboard after button press
		InputMethodManager inputManager = (InputMethodManager)
				getSystemService(Context.INPUT_METHOD_SERVICE);

		inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ? null :
				getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

	}

	public void onClick(View view) {
		int length;
		try{
            length = Integer.parseInt(askLength.getText().toString());
        }
        catch (NumberFormatException n){
            length = 10;
        }

		if (askLength.getText().length() == 0 || askLength.getText().length() > 100 ) {
			Toast.makeText(this, "Please enter a valid number (100 or less)",
					Toast.LENGTH_LONG).show();
			//System.out.println("length: " +  askLength.getText().length());

		}else{
			generatedPassword.setText(generatePassword(length));

		}
		//hide the keyboard after button press
		InputMethodManager inputManager = (InputMethodManager)
				getSystemService(Context.INPUT_METHOD_SERVICE);

		inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ? null :
				getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}
	public static String generatePassword(int length){
		int caseNumber;
		String password;
		char[] pass = new char[length];
		int specindex = 0;
		int numindex = 0;
		int upperindex = 0;
		int rand;
		Random r = new Random();

		if (includeSpecial&& !includeNumber && !includeUppers){
			caseNumber = 1;
		} else if (includeUppers && !includeSpecial && !includeNumber){
			caseNumber = 2;
		} else if (includeNumber && includeSpecial && !includeUppers){
			caseNumber = 3;
		} else caseNumber =0;


		switch(caseNumber){
			case 0:{
				for (int i=0; i< length; i++){
					if (includeSpecial) rand = r.nextInt(92);
					else if (includeUppers) rand = r.nextInt(62);
					else if (includeNumber) rand = r.nextInt(36);
					else rand = r.nextInt(26);
					switch (rand){
						case 0: pass[i] = 'a'; break;
						case 1: pass[i] = 'b';break;
						case 2: pass[i] = 'c';break;
						case 3: pass[i] = 'd';break;
						case 4: pass[i] = 'e';break;
						case 5: pass[i] = 'f';break;
						case 6: pass[i] = 'g';break;
						case 7: pass[i] = 'h';break;
						case 8: pass[i] = 'i';break;
						case 9: pass[i] = 'j';break;
						case 10: pass[i] = 'k';break;
						case 11: pass[i] = 'l';break;
						case 12: pass[i] = 'm';break;
						case 13: pass[i] = 'n';break;
						case 14: pass[i] = 'o';break;
						case 15: pass[i] = 'p';break;
						case 16: pass[i] = 'q';break;
						case 17: pass[i] = 'r';break;
						case 18: pass[i] = 's';break;
						case 19: pass[i] = 't';break;
						case 20: pass[i] = 'u';break;
						case 21: pass[i] = 'v';break;
						case 22: pass[i] = 'w';break;
						case 23: pass[i] = 'x';break;
						case 24: pass[i] = 'y';break;
						case 25: pass[i] = 'z';break;
						case 26: pass[i] = '1';break;
						case 27: pass[i] = '2';break;
						case 28: pass[i] = '3';break;
						case 29: pass[i] = '4';break;
						case 30: pass[i] = '5';break;
						case 31: pass[i] = '6';break;
						case 32: pass[i] = '7';break;
						case 33: pass[i] = '8';break;
						case 34: pass[i] = '9';break;
						case 35: pass[i] = '0';break;
						case 36: pass[i] = 'A';break;
						case 37: pass[i] = 'B';break;
						case 38: pass[i] = 'C';break;
						case 39: pass[i] = 'D';break;
						case 40: pass[i] = 'E';break;
						case 41: pass[i] = 'F';break;
						case 42: pass[i] = 'G';break;
						case 43: pass[i] = 'H';break;
						case 44: pass[i] = 'I';break;
						case 45: pass[i] = 'J';break;
						case 46: pass[i] = 'K';break;
						case 47: pass[i] = 'L';break;
						case 48: pass[i] = 'M';break;
						case 49: pass[i] = 'N';break;
						case 50: pass[i] = 'O';break;
						case 51: pass[i] = 'P';break;
						case 52: pass[i] = 'Q';break;
						case 53: pass[i] = 'R';break;
						case 54: pass[i] = 'S';break;
						case 55: pass[i] = 'T';break;
						case 56: pass[i] = 'U';break;
						case 57: pass[i] = 'V';break;
						case 58: pass[i] = 'W';break;
						case 59: pass[i] = 'X';break;
						case 60: pass[i] = 'Y';break;
						case 61: pass[i] = 'Z';break;
						case 62: pass[i] = '`';break;
						case 63: pass[i] = '-';break;
						case 64: pass[i] = '=';break;
						case 65: pass[i] = '/';break;
						case 66: pass[i] = '~';break;
						case 67: pass[i] = '!';break;
						case 68: pass[i] = '@';break;
						case 69: pass[i] = '#';break;
						case 70: pass[i] = '$';break;
						case 71: pass[i] = '%';break;
						case 72: pass[i] = '^';break;
						case 73: pass[i] = '&';break;
						case 74: pass[i] = '*';break;
						case 75: pass[i] = '(';break;
						case 76: pass[i] = ')';break;
						case 77: pass[i] = '_';break;
						case 78: pass[i] = '+';break;
						case 79: pass[i] = '{';break;
						case 80: pass[i] = '}';break;
						case 81: pass[i] = '[';break;
						case 82: pass[i] = ']';break;
						case 83: pass[i] = '\\';break;
						case 84: pass[i] = '|';break;
						case 85: pass[i] = ';';break;
						case 86: pass[i] = ':';break;
						case 87: pass[i] = '>';break;
						case 88: pass[i] = '<';break;
						case 89: pass[i] = '.';break;
						case 90: pass[i] = ',';break;
						case 91: pass[i] = '?';break;
						default: pass [i] = 'a';

					}//end switch
				}//end for
			} break; //end case
			case 1:{
				for (int i=0; i< length; i++){
					rand = r.nextInt(56);
					switch (rand){
						case 0: pass[i] = 'a'; break;
						case 1: pass[i] = 'b';break;
						case 2: pass[i] = 'c';break;
						case 3: pass[i] = 'd';break;
						case 4: pass[i] = 'e';break;
						case 5: pass[i] = 'f';break;
						case 6: pass[i] = 'g';break;
						case 7: pass[i] = 'h';break;
						case 8: pass[i] = 'i';break;
						case 9: pass[i] = 'j';break;
						case 10: pass[i] = 'k';break;
						case 11: pass[i] = 'l';break;
						case 12: pass[i] = 'm';break;
						case 13: pass[i] = 'n';break;
						case 14: pass[i] = 'o';break;
						case 15: pass[i] = 'p';break;
						case 16: pass[i] = 'q';break;
						case 17: pass[i] = 'r';break;
						case 18: pass[i] = 's';break;
						case 19: pass[i] = 't';break;
						case 20: pass[i] = 'u';break;
						case 21: pass[i] = 'v';break;
						case 22: pass[i] = 'w';break;
						case 23: pass[i] = 'x';break;
						case 24: pass[i] = 'y';break;
						case 25: pass[i] = 'z';break;
						case 26: pass[i] = '`';break;
						case 27: pass[i] = '-';break;
						case 28: pass[i] = '=';break;
						case 29: pass[i] = '/';break;
						case 30: pass[i] = '~';break;
						case 31: pass[i] = '!';break;
						case 32: pass[i] = '@';break;
						case 33: pass[i] = '#';break;
						case 34: pass[i] = '$';break;
						case 35: pass[i] = '%';break;
						case 36: pass[i] = '^';break;
						case 37: pass[i] = '&';break;
						case 38: pass[i] = '*';break;
						case 39: pass[i] = '(';break;
						case 40: pass[i] = ')';break;
						case 41: pass[i] = '_';break;
						case 42: pass[i] = '+';break;
						case 43: pass[i] = '{';break;
						case 44: pass[i] = '}';break;
						case 45: pass[i] = '[';break;
						case 46: pass[i] = ']';break;
						case 47: pass[i] = '\\';break;
						case 48: pass[i] = '|';break;
						case 49: pass[i] = ';';break;
						case 50: pass[i] = ':';break;
						case 51: pass[i] = '>';break;
						case 52: pass[i] = '<';break;
						case 53: pass[i] = '.';break;
						case 54: pass[i] = ',';break;
						case 55: pass[i] = '?';break;
						default: pass [i] = 'a';
					}//end switch
				}//end for

			} break;//end case
			case 2:{
				for (int i=0; i< length; i++){
					if (includeSpecial) rand = r.nextInt(92);
					else if (includeUppers) rand = r.nextInt(61);
					else if (includeNumber) rand = r.nextInt(35);
					else rand = r.nextInt(25);
					switch (rand){
						case 0: pass[i] = 'a'; break;
						case 1: pass[i] = 'b';break;
						case 2: pass[i] = 'c';break;
						case 3: pass[i] = 'd';break;
						case 4: pass[i] = 'e';break;
						case 5: pass[i] = 'f';break;
						case 6: pass[i] = 'g';break;
						case 7: pass[i] = 'h';break;
						case 8: pass[i] = 'i';break;
						case 9: pass[i] = 'j';break;
						case 10: pass[i] = 'k';break;
						case 11: pass[i] = 'l';break;
						case 12: pass[i] = 'm';break;
						case 13: pass[i] = 'n';break;
						case 14: pass[i] = 'o';break;
						case 15: pass[i] = 'p';break;
						case 16: pass[i] = 'q';break;
						case 17: pass[i] = 'r';break;
						case 18: pass[i] = 's';break;
						case 19: pass[i] = 't';break;
						case 20: pass[i] = 'u';break;
						case 21: pass[i] = 'v';break;
						case 22: pass[i] = 'w';break;
						case 23: pass[i] = 'x';break;
						case 24: pass[i] = 'y';break;
						case 25: pass[i] = 'z';break;
						case 26: pass[i] = 'A';break;
						case 27: pass[i] = 'B';break;
						case 28: pass[i] = 'C';break;
						case 29: pass[i] = 'D';break;
						case 30: pass[i] = 'E';break;
						case 31: pass[i] = 'F';break;
						case 32: pass[i] = 'G';break;
						case 33: pass[i] = 'H';break;
						case 34: pass[i] = 'I';break;
						case 35: pass[i] = 'J';break;
						case 36: pass[i] = 'K';break;
						case 37: pass[i] = 'L';break;
						case 38: pass[i] = 'M';break;
						case 39: pass[i] = 'N';break;
						case 40: pass[i] = 'O';break;
						case 41: pass[i] = 'P';break;
						case 42: pass[i] = 'Q';break;
						case 43: pass[i] = 'R';break;
						case 44: pass[i] = 'S';break;
						case 45: pass[i] = 'T';break;
						case 46: pass[i] = 'U';break;
						case 47: pass[i] = 'V';break;
						case 48: pass[i] = 'W';break;
						case 49: pass[i] = 'X';break;
						case 50: pass[i] = 'Y';break;
						case 51: pass[i] = 'Z';break;
						default: pass [i] = 'a';
					}//end switch
				}//end for

			} break;//end case
			case 3:{
				for (int i=0; i< length; i++){
					rand = r.nextInt(66);
					switch (rand){
						case 0: pass[i] = 'a'; break;
						case 1: pass[i] = 'b';break;
						case 2: pass[i] = 'c';break;
						case 3: pass[i] = 'd';break;
						case 4: pass[i] = 'e';break;
						case 5: pass[i] = 'f';break;
						case 6: pass[i] = 'g';break;
						case 7: pass[i] = 'h';break;
						case 8: pass[i] = 'i';break;
						case 9: pass[i] = 'j';break;
						case 10: pass[i] = 'k';break;
						case 11: pass[i] = 'l';break;
						case 12: pass[i] = 'm';break;
						case 13: pass[i] = 'n';break;
						case 14: pass[i] = 'o';break;
						case 15: pass[i] = 'p';break;
						case 16: pass[i] = 'q';break;
						case 17: pass[i] = 'r';break;
						case 18: pass[i] = 's';break;
						case 19: pass[i] = 't';break;
						case 20: pass[i] = 'u';break;
						case 21: pass[i] = 'v';break;
						case 22: pass[i] = 'w';break;
						case 23: pass[i] = 'x';break;
						case 24: pass[i] = 'y';break;
						case 25: pass[i] = 'z';break;
						case 26: pass[i] = '1';break;
						case 27: pass[i] = '2';break;
						case 28: pass[i] = '3';break;
						case 29: pass[i] = '4';break;
						case 30: pass[i] = '5';break;
						case 31: pass[i] = '6';break;
						case 32: pass[i] = '7';break;
						case 33: pass[i] = '8';break;
						case 34: pass[i] = '9';break;
						case 35: pass[i] = '0';break;
						case 36: pass[i] = '`';break;
						case 37: pass[i] = '-';break;
						case 38: pass[i] = '=';break;
						case 39: pass[i] = '/';break;
						case 40: pass[i] = '~';break;
						case 41: pass[i] = '!';break;
						case 42: pass[i] = '@';break;
						case 43: pass[i] = '#';break;
						case 44: pass[i] = '$';break;
						case 45: pass[i] = '%';break;
						case 46: pass[i] = '^';break;
						case 47: pass[i] = '&';break;
						case 48: pass[i] = '*';break;
						case 49: pass[i] = '(';break;
						case 50: pass[i] = ')';break;
						case 51: pass[i] = '_';break;
						case 52: pass[i] = '+';break;
						case 53: pass[i] = '{';break;
						case 54: pass[i] = '}';break;
						case 55: pass[i] = '[';break;
						case 56: pass[i] = ']';break;
						case 57: pass[i] = '\\';break;
						case 58: pass[i] = '|';break;
						case 59: pass[i] = ';';break;
						case 60: pass[i] = ':';break;
						case 61: pass[i] = '>';break;
						case 62: pass[i] = '<';break;
						case 63: pass[i] = '.';break;
						case 64: pass[i] = ',';break;
						case 65: pass[i] = '?';break;
						default: pass [i] = 'a';
					}//end switch
				}//end for
			} break;//end case

		}//end switch

		if (includeSpecial){
			specindex = (int)(Math.random()*length);
			pass[specindex] =specials.charAt((int)(Math.random()*specials.length()));

		}
		if (includeNumber){
			while (numindex == specindex){
				numindex = (int)(Math.random()*length);
			}
			pass[numindex] = Integer.toString(r.nextInt(10)).charAt(0);
		}
		if (includeUppers){
			while (upperindex == specindex || upperindex == numindex){
				upperindex = (int)(Math.random()*length);
			}
			pass[upperindex] = uppers.charAt((int)(Math.random()*uppers.length()));

		}

		password = new String(pass);
		password = password.trim();
		//System.out.println(password);

		return password;
	}//end method

    /**
     * Back button listener.
     * Will close the application if the back button pressed twice.
     */
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press back again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

}//end class
