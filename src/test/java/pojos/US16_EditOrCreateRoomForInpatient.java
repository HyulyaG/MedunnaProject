package pojos;

public class US16_EditOrCreateRoomForInpatient {

    private int roomNumber;
    private String roomType;
    private String status;
    private int price;
    private String description;
    private String date;

    public US16_EditOrCreateRoomForInpatient() {
    }

    public US16_EditOrCreateRoomForInpatient(int roomNumber, String roomType, String status, int price, String description, String date) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "US16_EditOrCreateRoomForInpatient{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}