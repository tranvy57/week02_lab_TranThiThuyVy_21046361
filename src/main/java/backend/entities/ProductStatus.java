package backend.entities;

public enum ProductStatus {
//    : 1- đang kinh doanh, 0 - tạm ngưng, -1 - không kinh doanh nữa.
    ACTIVE(1), PAUSED(0), INACTIVE(-1);

    private final int status;

    ProductStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}

