import sys
import pandas as pd
import matplotlib.pyplot as plt

filename = sys.argv[1]
df = pd.read_csv(filename, skipfooter=3, engine='python')
plt.plot(df['t'], df['fMin'], label='Fitness mínimo')
plt.plot(df['t'], df['fAvg'], label='Fitness promedio')
plt.plot(df['t'], df['fMax'], label='Fitness máximo')

plt.xlabel('Tiempo [mS]', fontsize=16)
plt.ylabel('Fitness', fontsize=16)
plt.legend(title='Tipo de fitness')
plt.show()