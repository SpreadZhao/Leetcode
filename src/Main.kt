import test.Test.connectNetwork
import test.Test.sumClosest
import test.Test.unreachableNodes

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
//        Test.romanInteger("MCMXCIV");
//        Test.longestCommonPrefix();
        val stime = System.currentTimeMillis()
        //        Test.sum();
//        Test.addTwoNumbers();
//        Test.longestSubstring();
//        Test.longestPalindromicSubstring();
//        Test.zigzagConversion();
//        Test.shuffleTheArray();
//        Test.reverseInteger();
//        Test.stringToInteger();
//        Test.palindromeNumber();
//        Test.integerToRoman();
//        Test.addBinary();
//        Test.addToArrayFormOfInteger();
//        Test.maxDepthOfBianryTree();
//        Test.regularExpressionMatching();
//        Test.searchInsertPosition();
//        Test.singleElementInASortedArray();
//        Test.containerWithMostWater();
//        sumClosest();
//        Test.sltoBst();
//        Test.symmetricTree();
//        Test.sumRootToLeafNumbers();
//        Test.trie();
//        Test.wordDict();
//        Test.canPlaceFlowers();
//        TestExercise.testGraph();
//        Test.mimimunScore();
//        connectNetwork()
        unreachableNodes()
        val etime = System.currentTimeMillis()
        println("time: " + (etime - stime))
    }
}