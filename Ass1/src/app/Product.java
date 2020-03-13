package app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    public String id, name, mfg;
    public int unitPrice, qoh;

    public Product() {
    }

    public Product(String id, String name, String mfg, int unitPrice, int qoh) {
        this.id = id;
        this.name = name;
        this.mfg = mfg;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        // Nhập kiểm tra id sản phẩm:Fxxxx hoặc Bxxxx với x là ký số;
        Pattern p = Pattern.compile("[FB]\\d{4}");
        Matcher m = null;
        while (true) {
            try {
                System.out.println("Nhập ID:");
                id = in.nextLine().trim();
                m = p.matcher(id);
                if (m.find()) {
                    break;
                } else {
                    throw new InvalidException("ID không hợp lệ: ID phải có dạng Fxxxx hoặc Bxxxx");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }

        }
        p = Pattern.compile("[a-z A-Z]{2,}");
        m = null;
        while (true) {
            try {
                System.out.println("Nhập Name:");
                name = in.nextLine().trim();
                m = p.matcher(name);
                if (m.find()) {
                    break;
                } else {
                    throw new InvalidException("Name không hợp lệ: Name phai ít nhất 2 ký tự:");
                }
            } catch (Exception e) {
                System.out.println("Lỗi" + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập đơn vị giá:");
                unitPrice = Integer.parseInt(in.nextLine().trim());
                if (unitPrice > 0) {
                    break;
                } else {
                    throw new InvalidException("Giá không hợp lệ: phải >0");
                }
            } catch (InvalidException e) {
                System.out.println("Lỗi:" + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập tồn kho:");
                qoh = Integer.parseInt(in.nextLine().trim());
                if (qoh > 0) {
                    break;
                } else {
                    throw new InvalidException("không hợp lệ: sản phẩm tồn kho phải >0");
                }
            } catch (InvalidException e) {
                System.out.println("Lỗi:" + e.getMessage());
            }
        }
        p = Pattern.compile("(US|VN|TL)", Pattern.CASE_INSENSITIVE);
        m = null;
        while (true) {
            try {
                System.out.println("Nhập mfg:");
                mfg = in.nextLine().trim();
                m = p.matcher(mfg);
                if (m.find()) {
                    break;
                } else {
                    throw new InvalidException("mfg Không hợp lệ: mfg phảcos dạng US hoặc TL hoặc VN!!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi:" + e.getMessage());
            }
        }
    }

    public String standardlizeMFG() {
        if ("US".equals(mfg)) {
            return mfg.replaceAll("VN", "My");
        }
        if ("VN".equals(mfg)) {
            return mfg.replaceAll("VN", "Vietnam");
        }
        if ("TL".equals(mfg)) {
            return mfg.replaceAll("TL", "ThaiLand");
        }
        return null;

    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d - %s", id, name, unitPrice, qoh, standardlizeMFG());
    }

}
