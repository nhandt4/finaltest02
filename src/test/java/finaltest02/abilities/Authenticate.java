package finaltest02.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Authenticate implements Ability {
    private String Email;
    private String Password;
    public String getEmail(){
        return this.Email;
    }
    public String getPassword(){
        return this.Password;
    }
    public Authenticate(String email, String Password){
        this.Email = email;
        this.Password = Password;
    }
    public static Authenticate LoadTestData(String actorName){
        try {
            Reader dataReader = new FileReader("src\\test\\resources\\TestData\\user."
                    +actorName.toLowerCase()+".properties");
            Properties dataProperties = new Properties();
            try {
                dataProperties.load(dataReader);
            } catch (IOException e) {
                e.printStackTrace();

            }
            String email = dataProperties.getProperty("email");
            String password = dataProperties.getProperty("password");
            return new Authenticate(email, password);
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }
        return new Authenticate("","");

    }
    public static Authenticate as(Actor actor){
        // read data
        if(actor.abilityTo(Authenticate.class)==null)
        {
            throw new ExceptionInInitializerError(actor.getName()+" have not got an Authenticat Ability");

        }else{
            return actor.abilityTo(Authenticate.class);
        }
    }
}
