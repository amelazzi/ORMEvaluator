package com.company.Common.Display;

public class DisplayArrayCatego {
    public DisplayArrayCatego() {
    }
    public void fetchArray(long[] values) {
        System.out.println("");
        System.out.println(" Fetch Category : ");
        System.out.println("\t+===============================++================+");
        System.out.println("\t|         Function Name         || Execution Time |");
        System.out.println("\t+===============================++================+");
          System.out.print("\t| Select By ID                  ||" );
        System.out.printf("%10d",values[0]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Select All                    ||" );
        System.out.printf("%10d",values[1]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Select With Constraints       ||" );
        System.out.printf("%10d",values[2]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Select With Joins             ||" );
        System.out.printf("%10d",values[3]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Select With Joins & Group By  ||" );
        System.out.printf("%10d",values[4]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
    }

    public void cudArray(long[] values) {
        System.out.println("");
        System.out.println(" CUD Category : ");
        System.out.println("\t+===============================++================+");
        System.out.println("\t|         Function Name         || Execution Time |");
        System.out.println("\t+===============================++================+");
          System.out.print("\t| Insert Single                 ||" );
        System.out.printf("%10d",values[0]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Insert Bulk                   ||" );
        System.out.printf("%10d",values[1]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Update Single                 ||" );
        System.out.printf("%10d",values[2]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Update Bulk                   ||" );
        System.out.printf("%10d",values[3]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Delete Single                 ||" );
        System.out.printf("%10d",values[4]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Delete Bulk                   ||" );
        System.out.printf("%10d",values[5]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
    }

    public void functionArray(long[] values) {
        System.out.println("");
        System.out.println(" Function Category : ");
        System.out.println("\t+===============================++================+");
        System.out.println("\t|         Function Name         || Execution Time |");
        System.out.println("\t+===============================++================+");
          System.out.print("\t| Stored Procedure              ||" );
        System.out.printf("%10d",values[0]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Inheritence                   ||" );
        System.out.printf("%10d",values[1]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );
          System.out.print("\t| Association                   ||" );
        System.out.printf("%10d",values[2]);
        System.out.printf("%7s","|");
        System.out.println("");
        System.out.println("\t+-------------------------------++----------------+" );

    }
}
