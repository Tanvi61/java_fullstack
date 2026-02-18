package Day_06;

/*
    dev : Tanvi Deshmukh
    Year  : 2026
    Description : This is container program
*/
public class Ram {

    public void getOrder(String teaName) throws InstantiationException, IllegalAccessException{
        try{
            Class cl = Class.forName(teaName);
            Object o = cl.newInstance();//Upcasting 
            Tea tea = (Tea)o;//Downcasting
            tea.benifits();
            tea.steps();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
