from setuptools import setup, find_packages
from convert_ply_to_obj.info import __package_name__, __version__

with open('READ.md', 'r', encoding='utf-8') as f :
    readme = f.read()
with open('requirements.txt', 'r', encoding='utf-8') as f:
    require = f.read().splitlines()

setup(
    name = __package_name__,
    version = __version__,
    long_description= readme,
    packages=find_packages(exclude=["contrib", "docs", "tests"]),
    package_data={'':['*.yml', '*.yaml']},
    requires= require
    
)