package com.company.Common.TestCategories;

public interface IFetchTest {
    long selectById();
    long selectAll();
    long selectWithConstraints();
    long selectWithJoins();
    long selectWithJoinsGroupBy();
}
