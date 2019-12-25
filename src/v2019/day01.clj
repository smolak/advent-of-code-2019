(ns v2019.day01)

(defn calculateFuelConsumption [mass] (int (- (Math/floor (/ mass 3)) 2)))
(defn calculateFuelRequirement
  [sum mass]
  (let [fuelCunsumption (calculateFuelConsumption mass)]
    (cond-> sum
            (neg? fuelCunsumption) (identity)
            (pos? fuelCunsumption) (+ (calculateFuelRequirement fuelCunsumption fuelCunsumption)))))

(defn processFile
      [filePath]
      (letfn [(toInt [string] (Integer/parseInt string))]
             (->> filePath
                  (slurp)
                  (clojure.string/split-lines)
                  (mapv toInt))))

(defn part1
  [filePath]

  (->> filePath
       (processFile)
       (mapv calculateFuelConsumption)
       (reduce +)))

(defn part2
  [filePath]

  (->> filePath
       (processFile)
       (mapv (partial calculateFuelRequirement 0))
       (reduce +)))

(defn main
  []
  (let [filePath "./resources/day01/input.txt"
        result1 (part1 filePath)
        result2 (part2 filePath)]
  (println "Day 1, part 1:" result1)
  (println "Day 1, part 2:" result2)))
