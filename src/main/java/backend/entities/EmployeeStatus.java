package backend.entities;

public enum EmployeeStatus {
    //1-đang làm việc, 0 tạm nghỉ, -1 nghỉ việc
    WORKING(1), REST(0), QUIT(-1);

    private final int status;

    EmployeeStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }




}
