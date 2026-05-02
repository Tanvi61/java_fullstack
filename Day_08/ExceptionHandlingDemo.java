package Day_08;


class ExceptionHandlingDemo {
    public static void main(String[] args) {
        
        try{
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c= a/b;
            System.out.println("Value of c : "+c);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch(NumberFormatException ef){
            System.out.println(ef);
        }catch(ArithmeticException ea){
            ea.printStackTrace();
        }
        
    }
}
