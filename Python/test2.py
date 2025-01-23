import numpy as np
import pandas as pd
import logging


df = pd.DataFrame(
    {
        "Name": [
        "Braund, Mr. Owen Harris",
        "Allen, Mr. William Henry",
        "Bonnell, Miss. Elizabeth",
        ],
        "Age": [22, 35, 58],
        "Sex": ["male", "male", "female"],
    },
 )

print(df.iloc[0,0]) 

logging.basicConfig(filename="Hello.log",filemode="w",  format='%(name)s - %(levelname)s - %(message)s', level=logging.DEBUG)
logging.debug("Hello")
logging.info("Helloi")
logging.warning("Helloi")
logging.error("Hellofkljwe;j")