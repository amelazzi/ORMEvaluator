package com.company.Common.Display;

public class DisplayArrayCompByCatego {

    public void fetchCatego(long[] hibernateResult, long[] myBatisResult){
        System.out.println("");
        System.out.println(" Fetch Category : ");
        System.out.println("\t|================================++==================+==================+");
        System.out.println("\t|            Functions           ||     Hibernate    |      MyBatis     |");
        System.out.println("\t|================================++==================+==================+");
          System.out.print("\t|  Select By ID                  ||" );
        System.out.printf("%11d",hibernateResult[0]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[0]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Select All                    ||" );
        System.out.printf("%11d",hibernateResult[1]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[1]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Select With Constraints       ||" );
        System.out.printf("%11d",hibernateResult[2]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[2]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Select With Joins             ||" );
        System.out.printf("%11d",hibernateResult[3]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[3]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Select With Joins & Group By  ||" );
        System.out.printf("%11d",hibernateResult[4]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[4]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|================================++===================+=================+");

    }

    public void cudCatego(long[] hibernateResult, long[] myBatisResult){
        System.out.println("");
        System.out.println(" CUD Category : ");
        System.out.println("\t|================================++==================+==================+");
        System.out.println("\t|            Functions           ||     Hibernate    |      MyBatis     |");
        System.out.println("\t|================================++==================+==================+");
          System.out.print("\t|  Insert Single                 ||" );
        System.out.printf("%11d",hibernateResult[0]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[0]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Insert Bulk                   ||" );
        System.out.printf("%11d",hibernateResult[1]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[1]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Update single                 ||" );
        System.out.printf("%11d",hibernateResult[2]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[2]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Update Bulk                   ||" );
        System.out.printf("%11d",hibernateResult[3]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[3]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Delete Single                 ||" );
        System.out.printf("%11d",hibernateResult[4]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[4]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Delete Bulk                   ||" );
        System.out.printf("%11d",hibernateResult[5]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",hibernateResult[5]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|================================++===================+=================+");

    }

    public void functionCatego(long[] hibernateResult, long[] myBatisResult){
        System.out.println("");
        System.out.println(" Function Category : ");
        System.out.println("\t|================================++==================+==================+");
        System.out.println("\t|            Functions           ||     Hibernate    |      MyBatis     |");
        System.out.println("\t|================================++==================+==================+");
          System.out.print("\t|  Stored Procedure              ||" );
        System.out.printf("%11d",hibernateResult[0]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[0]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Inheritence                   ||" );
        System.out.printf("%11d",hibernateResult[1]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[1]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|--------------------------------++------------------+------------------+");
          System.out.print("\t|  Association                   ||" );
        System.out.printf("%11d",hibernateResult[2]);
        System.out.printf("%8s","|");
        System.out.printf("%11d",myBatisResult[2]);
        System.out.printf("%8s","|");
        System.out.println("");
        System.out.println("\t|================================++===================+=================+");

    }
}
