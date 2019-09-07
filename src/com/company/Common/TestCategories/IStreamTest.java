package com.company.Common.TestCategories;

public interface IStreamTest {
    long selectById();
    long selectAll();
    long selectWithConstraints();
    long selectWithJoins();
    long selectWithJoinsGroupBy();
}
