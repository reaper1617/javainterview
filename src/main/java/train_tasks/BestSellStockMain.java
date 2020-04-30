package train_tasks;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestSellStockMain {

    public static int maxProfit(int[] prices) {
        int transactionResult = 0;
        int counter = 0;
        int[] res;
        while (counter < prices.length - 1) {
            res = findFirstRaiseSequence(prices, counter, prices.length - 1);
            int startIndex = res[0];
            int endIndex = res[1];
            if (startIndex != -1 && endIndex != -1) {
                transactionResult -= prices[startIndex];
                transactionResult += prices[endIndex];
                counter = endIndex + 1;
            }
            else {
                return transactionResult;
            }
        }
        return transactionResult;
    }

    private static int[] findFirstRaiseSequence(int[] arr, int start, int end) {
        if (arr.length < 2) throw new IllegalArgumentException("Empty arr!");
        int[] res = new int[2];

        int startSeqInd = start;
        int endSeqInd = start;

        boolean sequenceFound = false;
        for (int i = start; i < end; i++) {
            if (arr[i + 1] > arr[i]) {
                endSeqInd = i + 1;
                sequenceFound = true;
            } else {
                if (sequenceFound) break;
                startSeqInd = i + 1;
            }
        }
        if (sequenceFound) {
            res[0] = startSeqInd;
            res[1] = endSeqInd;
        } else {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        int maxProfit = maxProfit(prices);
        System.out.println("Max profit: " + maxProfit);
    }
}
