package com.whs.db;

import java.util.List;

public interface IDBHelperWorkTime {
    public void addWorkTime(WorkTime workTime);
    public Store getWorkTime(int id);
    public int updateWorkTime(WorkTime workTime);
    public void deleteWorkTime(WorkTime workTime);
}
