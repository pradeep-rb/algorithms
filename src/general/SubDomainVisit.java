package general;



import java.util.*;

//https://leetcode.com/problems/subdomain-visit-count/
public class SubDomainVisit {


    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> domainMap = new LinkedHashMap<>();
        List<String> result = new ArrayList();

        for(String domain: cpdomains) {
            String[] dmnPartsByCnt =  domain.split("\\s+");
            int cnt = Integer.parseInt( dmnPartsByCnt[0]);
            domainMap.put(dmnPartsByCnt[1], domainMap.getOrDefault(domain, 0) + cnt);
            String[] parts = dmnPartsByCnt[1].split("\\.", 2);
            while(parts.length > 1) {
                domainMap.put(parts[1], domainMap.getOrDefault(parts[1], 0) + cnt);
                parts = parts[1].split("\\.", 2);
            }

        }

        for(Map.Entry entry: domainMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }


    public static void main(String[] args) {
        SubDomainVisit sVisit = new SubDomainVisit();

        System.out.println(sVisit.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(sVisit.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
