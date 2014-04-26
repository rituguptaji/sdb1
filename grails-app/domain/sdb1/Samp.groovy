package sdb1

class Samp {
String name
    static constraints = {
		//name (inList: ["great", "also","पुल्लिङ्ग्", "स्त्रिलिङ्ग्" ,"नपुन्सकलिङ्ग्" ])
		name (inList: ["पुल्लिङ्ग्", "स्त्रिलिङ्ग्" ,"नपुन्सकलिङ्ग्" ])
    }
}
