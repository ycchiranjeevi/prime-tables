(defproject prime-table "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies 
	[[org.clojure/clojure "1.8.0"]]
  :main prime-table.core
  :plugins [[cider/cider-nrepl "0.16.0"]
	    [test2junit "1.4.2"]]
  :aot :all
)