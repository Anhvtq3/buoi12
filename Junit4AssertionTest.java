package Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Junit4AssertionTest {
    @Test
 @DisplayName("TestArray")
    public void testMethod_Arrays(){
        String [] contries = new String[]{"Russia","Viet Nam","America","Japan","China"};
        assertThat(contries).isNotEmpty();  //Mang khong rong
        assertThat(contries).startsWith("Russia"); //Bắt đầu là phần tử Russia
        assertThat(contries).isNotEmpty()//Array is not empty
                .contains("Viet Nam")
                .doesNotContainNull()
                .containsSequence("America","Japan")
                .hasSize(5);
        int [] number = new int[]{1,2,3,4,5};
        assertThat(number).contains(1);

    }
    public void testMethod_String(){
        String say ="chị không muốn nhiều bug nhưng bug nhiều nên chị phải fix";
        String sayClone=say;
        assertThat(say).isNotNull() //String is not empty
                .contains("bug")
                .doesNotContain("Anh")
                .contains("bug")
                .endsWith("fix");
        assertThat(say).isEqualTo(sayClone);

    }
    public void testMethod_Checkphone(){
        String phone ="0989857473";
        assertThat(phone).startsWith("0")
                .hasSize(10)
                .containsOnlyDigits();


    }
    public  void testMethod_CheckEmail(){
        String email ="anhvtq3@onemount.com";
        assertThat(email).containsSequence(".com")
                .containsOnlyOnce("@")
                .doesNotContain("!@#$%^&*()")
                .isNotNull()
                .containsPattern("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");

    }
    public  void testMethod_CheckWeight(){
        double weight=85.5;
        assertThat(weight).isNotNegative()
                .isNotNull();


    }
    public void testMethod_CheckIdentity(){
        String [] indentity = new String[]{"123456576545","876756545678","D879476876789","878765787","987656784"};
       for (String s: indentity){
           try {
               assertThat(s.length()).isIn(9,12);
               assertThat(s).containsOnlyDigits();

           }catch (AssertionError e){
               throw new AssertionError("Số chứng minh thư không đúng: "+ s + e.getMessage() );
           }
       }
    }

}
