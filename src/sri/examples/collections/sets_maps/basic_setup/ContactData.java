package sri.examples.collections.sets_maps.basic_setup;

import java.util.*;

public class ContactData {
    private static final String phoneData= """
            Nandam Akhila,99472314010
            Nandam Akhila,99472314009
            Nandam Akhila,99472314008
            Pratibha Anugulia,9947231401
            LOKESH BAILAPUDI,9947231402
            Jaddu balaji,9947231403
            Sindhuja kodari,9947231404
            Rishitha Budiputi,9947231405
            Hemanthkumar Cherukuri,9947231406
            Sai Alekhya Chouthai,9947231407
            Ramarao Chukka,9947231408
            Datla Naga Venkata Sai Durga Deepthi,9947231409
            Prathyusha Dendukuri,9947231410
            Narendra Gompa,9947231411
            Kundrapu Jayababu,9947231412
            Anumala Sai Krishna,9947231413
            Vinay Kumar Kudama,9947231414
            Putta Raj Kumar,9947231415
            VALLURI KUMARA SANKARA,9947231416
            Mutta Meenakeswararao,9947231417
            Nikhil Nagaraju,9947231418
            Battini Omkar,9947231419
            panditi,9947231420
            Akash Uttam Pawar,9947231421
            Lakshmi Prasanna,9947231422
            UJIGIRI PRASHANTH,9947231423
            Bhanu prasad puli,9947231424
            Dommeti Raja,9947231425
            Peddi Rajendhar,9947231426
            NAKKALA SRINIVASA RAO,9947231427
            Vamshidhar Reddy,9947231428
            Saurabh Mani Tripathi,9947231429
            Kundrapu Vijayababu,9947231430
            Akkapally Vinod,9947231431
            """;
    private static final String emailData= """
            Nandam Akhila,Nandam_Akhila1@gmail.com
            Nandam Akhila,Nandam_Akhila2@gmail.com
            Nandam Akhila,Nandam_Akhila3@gmail.com
            Pratibha Anugulia,Pratibha_Anugulia@gmail.com
            LOKESH BAILAPUDI,LOKESH_BAILAPUDI@gmail.com
            Jaddu balaji,Jaddu_balaji@gmail.com
            Sindhuja kodari,Sindhuja_kodari@gmail.com
            Rishitha Budiputi,Rishitha_Budiputi@gmail.com
            Hemanthkumar Cherukuri,Hemanthkumar_Cherukuri@gmail.com
            Sai Alekhya Chouthai,Sai_Alekhya_Chouthai@gmail.com
            Ramarao Chukka,Ramarao_Chukka@gmail.com
            Datla Naga Venkata Sai Durga Deepthi,Datla_Naga_Venkata_Sai_Durga_Deepthi@gmail.com
            Prathyusha Dendukuri,Prathyusha_Dendukuri@gmail.com
            Narendra Gompa,Narendra_Gompa@gmail.com
            Kundrapu Jayababu,Kundrapu_Jayababu@gmail.com
            Anumala Sai Krishna,Anumala_Sai_Krishna@gmail.com
            Vinay Kumar Kudama,Vinay_Kumar_Kudama@gmail.com
            Putta Raj Kumar,Putta_Raj_Kumar@gmail.com
            VALLURI KUMARA SANKARA,VALLURI_KUMARA_SANKARA@gmail.com
            Mutta Meenakeswararao,Mutta_Meenakeswararao@gmail.com
            Nikhil Nagaraju,Nikhil_Nagaraju@gmail.com
            Battini Omkar,Battini_Omkar@gmail.com
            panditi,panditi@gmail.com
            Akash Uttam Pawar,Akash_Uttam_Pawar@gmail.com
            Lakshmi Prasanna,Lakshmi_Prasanna@gmail.com
            UJIGIRI PRASHANTH,UJIGIRI_PRASHANTH@gmail.com
            Bhanu prasad puli,Bhanu_prasad_puli@gmail.com
            Dommeti Raja,Dommeti_Raja@gmail.com
            Peddi Rajendhar,Peddi_Rajendhar@gmail.com
            NAKKALA SRINIVASA RAO,NAKKALA_SRINIVASA_RAO@gmail.com
            Vamshidhar Reddy,Vamshidhar_Reddy@gmail.com
            Saurabh Mani Tripathi,Saurabh_Mani_Tripathi@gmail.com
            Kundrapu Vijayababu,Kundrapu_Vijayababu@gmail.com
            Akkapally Vinod,Akkapally_Vinod@gmail.com
            """;
    public static List<Contact> getData(String type){
        List<Contact> dataList=new ArrayList<>();
        Scanner scanner=new Scanner(type.equals("phone")?phoneData:emailData);
        while (scanner.hasNext()){
            String[] data=scanner.nextLine().split(",");
            Arrays.asList(data).replaceAll(String::trim);
            if(type.equals("phone")){
                dataList.add(new Contact(data[0],Long.parseLong(data[1])));
            }else if(type.equals("email")){
                dataList.add(new Contact(data[0],data[1]));
            }
        }
        return dataList;
    }


}
