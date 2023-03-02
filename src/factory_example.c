void makeWorld() {
    Map mp = loadMap();

    for (int i = 0; i <= 100; i++) {
        Car c = generateCar();
        mp.spawn(c)
    }

    for (int i = 0; i <= 50; i++) {
        NPC n = generateNPC();
        mp.spawn(n)
    }

    for (int i = 0; i <= 18; i++) {
        Cloud c = generateCloud();
        mp.spawn(n)
    }

    mp.startTime(900) // 1400 max
}