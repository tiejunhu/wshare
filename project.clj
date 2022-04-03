(defproject wshare "1.0.0-SNAPSHOT"
  :source-paths ["src/server" "src/client"]
  :dependencies [[thheller/shadow-cljs "2.17.8"]
                 [com.taoensso/sente "1.16.2"]
                 [com.taoensso/timbre "5.2.1"]
                 [macchiato/core "0.2.22"]
                 [macchiato/auth "0.0.10"]
                 [macchiato/hiccups "0.4.1"]
                 [bidi "2.1.6"]
                 [reagent "1.1.1"]
                 [re-frame "1.2.0"]]
  :plugins [[lein-ancient "1.0.0-RC3"]])
