public class theAncientArtOfParsingTime {
    public static void main(String[] args) {
        String[] validTestCases = { "10:08 AM", "6:45 pm", "03:12 AM", " 7:23 Pm ", "444AM", "0534", "23:59", "800", "0035" };
        String[] invalidTestCases = { "10 08 AM", "4:14 P M", "006:45 pm", "012:30 am", "9:5 PM", "102:3", "1:47 AMM", "PM 7:37", "4:67 AM", "2553", "noon" };
        
        System.out.println("Valid Cases (" + validTestCases.length + "): ");
        for (String valid : validTestCases) {
            int result = parseTime(valid);
            System.out.println(
                               (result != -1? "pass" : "FAIL") +
                               (" parseTime(\"" + valid + "\"): " + result)
                              );
        }
        
        System.out.println("\n\n\n");
        
        System.out.println("Invalid Cases (" + invalidTestCases.length + "): ");
        for (String invalid : invalidTestCases) {
            int result = parseTime(invalid);
            System.out.println(
                               (result == -1? "pass" : "FAIL") +
                               (" parseTime(\"" + invalid + "\"): " + result)
                              );
        }
        
        // use for any extra testing you have
        String[] jawBreakers = {
            "10;01 pm", "::", "111", "69", "69:0", "12", "041", "0:31", "12:42: ", "12:42 am :",
            "am 1423", "a 5:23 pm", "512, am", "12 23", "am", "m", "kevin is super cool uwu!"
        };
        
        System.out.println("\n\n\n");
        
        System.out.println("Jaw Breakers (no more jaw ;-;) (" + jawBreakers.length + "): ");
        for (String noMoreJaw_UwU_OwO_rawr : jawBreakers) {
            System.out.println("parseTime(\"" + noMoreJaw_UwU_OwO_rawr + "\"): " + parseTime(noMoreJaw_UwU_OwO_rawr));
        }
    }
    
    public static int parseTime(String timeStr) {
        // set to true if you want more verbose errors
        boolean debug = false;
        
        String ts = timeStr.trim().toLowerCase();
        char[] ca = ts.toCharArray();
        
        // there's never enough time
        int time = 0;
        int h = 0;
        int m = 0;
        
        // military time
        boolean mt = true;
        boolean isAm = false;
        
        
        // we need to verify all the checks
        // 1-2 numbers
        // optional colon
        // 2 numbers
        // optional spaces
        // A or P
        // M
        
        // int count
        int ic = 0;
        for (char c : ca) {
            if (isDigit(c)) ic++;
        }
        
        // only possible to have 3 or 4 digits total.
        if (!(ic == 3 || ic == 4)) {
            if (debug) System.out.println("Invalid amount of digits!");
            return -1;
        };
        
        // I'm sorry if my variable names are atrociously short, my thoughts
        // are jumbled, I just lost all my progress after my computer crashed,
        // so I'm actually retyping this. Shorter variable names will have to do for now.
        // sorry!
        // index of colon
        int ioc = 0;
        // colon count
        int cc = 0;
        for (int i=0; i<ca.length; i++) {
            if (ca[i] == ':') {
                ioc = i;
                cc++;
            }
        }
        
        // there can only be one or less colon
        if (cc > 1) {
            if (debug) System.out.println("There can only be 0-1 colons.");
            return -1;
        }
        
        // now we need to make sure the colon is in the right place
        // if there IS a colon...
        if (cc == 1) {
            // if there are three numbers, it must be at ca[1]
            if (ic == 3) {
                // 4:20
                if (!(ca[1] == ':')) {
                    if (debug) System.out.println("There are 3 numbers, the colon's in the wrong spot.");
                    return -1;
                }
            } else {
                // otherwise, it must be at ca[2]
                // 12:40
                if (!(ca[2] == ':')) {
                    if (debug) System.out.println("There are 4 numbers, the colon's in the wrong spot.");
                    return -1;
                }
            }
        }
        
        // now let's check if the numbers are in the right place
        if (ic == 3) {
            // I could've made this into one huge if statement, but sadly I think this is much easier on the eyes
            boolean bad = false;
            if (!isDigit(ca[0])) bad = true;
            if (!isDigit(ca[1 + cc])) bad = true; // the minutes should be offset by the existance of a colon
            if (!isDigit(ca[2 + cc])) bad = true;
            
            if (bad) {
                if (debug) System.out.println("There are 3 numbers, the numbers are in the wrong spot.");
                return -1;
            }
        } else { // there are 4 digits
            boolean bad = false;
            if (!isDigit(ca[0])) bad = true;
            if (!isDigit(ca[1])) bad = true;
            if (!isDigit(ca[2 + cc])) bad = true;
            if (!isDigit(ca[3 + cc])) bad = true;
            
            if (bad) {
                if (debug) System.out.println("There are 4 numbers, the numbers are in the wrong spot.");
                return -1;
            }
        }
        
        // we've verified the colon and the numbers, now we need to check if it's 24 hour time
        // we can do this by looping through and joining everything that's not a number, then trimming the result
        // sadly we can't just check if it's a letter, since we also need to check if there are spaces between am and pm
        // another short variable name, short for String Accumulator
        // god I'm so dizzy
        String sa = "";
        for (char c : ca) {
            if (!isDigit(c)) {
                sa += c;
            }
        }
        
        // it should already be lowercased when ts was declared, so we can safely equate to "am" or "pm"
        // we also need to cut out any colons we may have taken with us.
        // since we trimmed it at ts declaration, there are no spaces before the colon either.
        // IF there even is a colon, it's the first non space
        sa = sa
            .substring(cc) // remove the colon
            .trim(); // remove any remaining whitespace
        
        // if there are any letters, it can only be none, am, or pm. Either 0, or 2.
        // if there are any spaces between am and pm, or any extra letters, it won't be just 0 or 2.
        if (!(sa.length() == 0 || sa.length() == 2)) {
            if (debug) System.out.println("There can only be 0/2 letters.");
            return -1;
        }
        
        // if there are letters...
        if (sa.length() == 2) {
            // it's not military time
            mt = false;
            
            // it can only be "am" or "pm".
            if (sa.equals("am")) {
                isAm = true;
            } else if (sa.equals("pm")) {
                // do nothing, isAm is already false
            } else {
                // if there are letters, but it's not either am or pm, we can only assume it's an invalid date.
                if (debug) System.out.println("Invalid after letter thingy, it can only be am/pm");
                return -1;
            }
        }
        
        // now that we know if it's military time or not, we need to parse the time into hours and minutes
        // first, let's parse hours
        if (ic == 3) {
            // https://stackoverflow.com/a/4968343/12894940
            h = Character.getNumericValue(ca[0]);
        } else {
            h = (Character.getNumericValue(ca[0])*10) + Character.getNumericValue(ca[1]);
        }
        
        // if it's am/pm, the limit is 1-12
        if (!mt) {
            if (h == 0 || h > 12) {
                if (debug) System.out.println("Hours are out of range! The limit is 1-12.");
                return -1;
            }
            
            // 11am is 11, 12am is 0, 11pm is 23, 12pm is 12
            // am/pm is so dumb istfg I'll rip my hair out
            // if it's 12, we can do h -= 12
            // 11am would be 11, 12pm is 12, so it would be subtracted to 0. It's a pm, so we would add 12, totaling to 12.
            // 11pm would be 23, 12am is 0, so it would be subtracted to 0.
            if (h == 12) h = 0;
            
            // if it's pm, h += 12
            if (!isAm) h += 12;
            
            // 12:01 pm
            h %= 24;
        } else {
            // verify hours are under 24 (24 is invalid)
            if (!(h < 24)) {
                if (debug) System.out.println("Hours are out of range. The limit is 24.");
                return -1;
            }
        }
        
        // now it's time to parse the minutes.
        // we can guarantee there are two numbers, thanks to our previous checks
        if (ic == 3) {
            // 420
            // 2:12
            m = (Character.getNumericValue(ca[1 + cc]) * 10) + Character.getNumericValue(ca[2 + cc]);
        } else {
            // 1010
            // 12:29
            m = (Character.getNumericValue(ca[2 + cc]) * 10) + Character.getNumericValue(ca[3 + cc]);
        }
        
        // now time for minute validation!
        // hang in there, we're almost at the end of this odyssey
        if (!(m < 60)) {
            if (debug) System.out.println("Minutes are out of range. The limit is 59.");
            return -1;
        }
        
        // finally, inner peace
        return (h * 60) + m;
    }
    
    public static boolean isDigit(char character) {
        return Character.isDigit(character);
    }
}