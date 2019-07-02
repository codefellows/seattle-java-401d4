// the test we wrote for checking that random quotes were actually random

@Test
    public void testGenerateRandomQuote_actuallyGivesRandomQuotes() {
        Quote[] quotes = new Quote[] {
                new Quote(new String[0], "Michelle", "475", "potato"),
                new Quote(new String[0], "Michelle", "475", "pineapple")
        };
        // get a random quote
        // get another random quote
        // make sure they're not the same
        // but there's a 50% chance they are the same by randomness!
        // instead:
        // run it a bunch of times
        // make sure you're close to a 50/50 distribution
        int[] times = new int[]{0, 0};
        for (int i = 0; i < 100000; i++) {
            Quote q = App.generateRandomQuote(quotes);
            if (q == quotes[0]) {
                times[0]++;
            } else {
                times[1]++;
            }
        }
        assertEquals("number of times each was picked should be close to 50000",
                50000, times[0], 2000); // 48000 - 52000 will count as "equal"
    }