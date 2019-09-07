package com.company.Common.TestCategories;

import java.text.ParseException;


public interface ICUDTest {
   long insertBulk() throws ParseException;
   long insertSingle();
   long updateBulk();
   long upddateSingle();
   long deleteBulk();
   long deleteSingle();
}
