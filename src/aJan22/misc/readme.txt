8. String to Integer (atoi)

*   result = 10 * result + digit;  to  build the integer
*  (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)  to check the over/underflow


 while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }
------------------------------------------------------------------------------------------------------------------------------------------
