package az.umid.aiintegrationservice.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String askGemini(String message) {

        String msg = message.toLowerCase();

        
        if (msg.contains("salam")) {
            return "Salam! Gömrük AI sisteminə xoş gəlmisiniz. Sizə necə kömək edə bilərəm?";
        }

        
        if (msg.contains("gömrük") || msg.contains("vergi")) {
            return "Gömrük rüsumu malın dəyəri, növü və mənşə ölkəsinə görə hesablanır. Ətraflı məlumat üçün HS kod tələb olunur.";
        }

        
        if (msg.contains("bəyannamə")) {
            return "Bəyannamə elektron qaydada gömrük portalı vasitəsilə təqdim olunur. Sizdən malın dəyəri, çəkisi və sənədlər tələb olunur.";
        }

        
        if (msg.contains("çat") || msg.contains("ne vaxt")) {
            return "Bağlamanın çatdırılma müddəti ölkədən və daşıyıcıdan asılı olaraq 5-20 iş günü arasında dəyişir.";
        }

        
        if (msg.contains("limit")) {
            return "Fiziki şəxslər üçün aylıq idxal limiti 300 ABŞ dollarıdır. Bu limiti keçdikdə rüsum tətbiq olunur.";
        }

        
        if (msg.contains("cərimə")) {
            return "Gömrük qaydalarının pozulması halında cərimə tətbiq oluna bilər. Məbləğ pozuntunun növündən asılıdır.";
        }

        
        if (msg.contains("sənəd")) {
            return "Gömrük üçün əsas sənədlər: invoice, qaimə, mənşə sertifikatı və nəqliyyat sənədləridir.";
        }

        
        if (msg.contains("qadağan")) {
            return "Bəzi malların idxalı qadağandır: silah, narkotik vasitələr və icazəsiz dərman preparatları.";
        }

        
        if (msg.contains("broker")) {
            return "Gömrük brokeri sizin adınıza rəsmiləşdirmə işlərini həyata keçirən rəsmi nümayəndədir.";
        }

     
        if (msg.contains("status")) {
            return "Bağlamanızın statusunu daşıyıcı şirkətin izləmə sistemi vasitəsilə yoxlaya bilərsiniz.";
        }

     
        if (msg.contains("ödə")) {
            return "Gömrük ödənişləri onlayn portal və ya bank vasitəsilə həyata keçirilə bilər.";
        }

       
        return "Sorğunuz qeydə alındı. Ətraflı məlumat üçün gömrük xidmətləri ilə əlaqə saxlayın.";
    }
}