package Day_08;

public class VotingApplication {
    String checkage(int age) throws ValidateAgeException{
        if(age < 18)
            throw new ValidateAgeException("Your age is below 18");
        else
            return "You can vote..!!";
    }

    public static void main(String[] args) {
        VotingApplication vote = new VotingApplication();
        try{
            String msg = vote.checkage(19);
            System.out.println(msg);
        }catch(ValidateAgeException v){
            v.printStackTrace();
        }
        
    }
}
