package com.example.assignment1;

public class QuestionAnswer {

    public static String questions[]={
            "What is recurrence for worst case of QuickSort and what is the time complexity in Worst case?",
            "Which of the following is not a stable sorting algorithm in its typical implementation.",
            "Which of the following algorithms is NOT a divide & conquer algorithm by nature?",
            "Consider the polynomial p(x) = a0 + a1x + a2x^2 +a3x^3, where ai != 0, for all i. The minimum number of multiplications needed to evaluate p on an input x is:",
            "You have to sort 1 GB of data with only 100 MB of available main memory. Which sorting technique will be most appropriate?"
    };

    public static String choices[][] = {
            {"Recurrence is T(n) = T(n-1) + O(n) and time complexity is O(n^2)", "Recurrence is T(n) = T(n-2) + O(n) and time complexity is O(n^2)", "Recurrence is T(n) = 2T(n/2) + O(n) and time complexity is O(nLogn)", "Recurrence is T(n) = T(n/10) + T(9n/10) + O(n) and time complexity is O(nLogn)"},
            {"Bubble Sort", "Merge Sort", "Insertion Sort", "Quick Sort"},
            {"Euclidean algorithm to compute the greatest common divisor", "Heap Sort", "Cooley-Tukey fast Fourier transform", "Quick Sort"},
            {"4", "6", "9", "3"},
            {"Merge Sort", "Heap Sort", "Quick Sort", "Insertion Sort"}

    };

    public static String correctAnswers[] = {
            "Recurrence is T(n) = T(n-1) + O(n) and time complexity is O(n^2)",
            "Quick Sort",
            "Heap Sort",
            "3",
            "Merge Sort"
    };
}
