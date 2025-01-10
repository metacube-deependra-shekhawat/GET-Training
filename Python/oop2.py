from abc import abstractmethod

class TouchScreenLaptop:
    @abstractmethod
    def scroll(self):
        pass

    @abstractmethod
    def click(self):
        pass

class hp(TouchScreenLaptop):
    def scroll(self):
        print("Scrolling in hp laptop")

class dell(TouchScreenLaptop):
    def scroll(self):
        print("Scrolling in dell laptop")

class hpnotebook(hp):
    def click(self):
        print("Clicking in hp notebook")

class dellnotebook(dell):
    def click(self):
        print("Clicking in dell notebook")

hp_notebook = hpnotebook()
hp_notebook.scroll()
hp_notebook.click()

dell_notebook = dellnotebook()
dell_notebook.scroll()
dell_notebook.click()